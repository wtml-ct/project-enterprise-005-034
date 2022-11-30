<template>
<div>
    <h3 class="mt-2 text-center" style="font-weight: 700; font-size: 250%;">History</h3>
    <div>
        <v-layout wrap>
            <v-flex lg3 md4 sm12 xs6 v-for="(b, idx) in this.booking" :key="idx" :items="booking">
                <v-card class="card">
                    <div class="img">
                        <img style="" class="img" :src="b.bookingBook.image" />
                    </div>
                    <v-card-title>{{ b.bookingBook.title }}</v-card-title>
                    <v-card-title>{{ b.user.name }}</v-card-title>
                    <v-card-text>
                        <div>Date : {{ b.date }}</div>
                        <div>Description : {{ b.bookingBook.description }}</div>
                    </v-card-text>
                    <br><br>
                    <v-row class="roww">
                        <v-btn rounded class="cen mb-5" color="orange" @click="onOpenEdit(b)">
                            EDIT
                        </v-btn>
                        <v-dialog v-model="dialog" persistent max-width="400px">
                            <v-card>
                                <v-card-title>
                                    <span class="cen text-h5">Edit Date</span>
                                </v-card-title>
                                <v-card-text>
                                    <v-container>
                                        <v-row>
                                            <v-text-field outlined style="padding:10px" v-model.trim="form.date" label="Date"></v-text-field>
                                        </v-row>
                                    </v-container>
                                </v-card-text>
                                <v-card-actions>
                                    <v-spacer></v-spacer>
                                    <v-btn rounded color="red darken-1" dark text @click="dialog = false">
                                        Close
                                    </v-btn>
                                    <v-btn rounded color="blue darken-1" dark text @click="onEditBooking()">
                                        Save
                                    </v-btn>
                                </v-card-actions>
                            </v-card>
                        </v-dialog>
                        <v-btn dark rounded class="cen mb-5" color="red" @click="onDeleteBooking(b)">
                            DELETE
                        </v-btn>
                    </v-row>
                </v-card>
            </v-flex>
        </v-layout>
    </div>
</div>
</template>

<script>
import Axios from "axios";
export default {
    component: {},
    name: 'Booking',
    data() {
        return {
            author: [],
            booking: [],
            form: {
                date: ""
            },
            dialog: false,
        };

    },
    computed: {},
    watch: {},
    mounted() {},
    created() {
        this.user = JSON.parse(sessionStorage.getItem("users"))
        Axios.get("/api/getAllBookings").then((res) => {
            var bb = res.data
            var book = bb.filter((data) => data.user.id == this.user.id)
            if (book == undefined) {
                alert("Dont have booking.");
            } else {
                this.booking = book;
            }
        })
    },
    beforeDestroy() {},
    methods: {
        onDeleteBooking(index) {
            console.log(index.id)
            Axios.delete("/api/deleteBookingById/" + index.id).then((res) => {
                Axios.get("/api/getAllBookings").then((res) => {
                    var bb = res.data
                    var book = bb.filter((data) => data.user.id == this.user.id)
                    if (book == undefined) {
                        alert("Dont have booking.");
                    } else {
                        this.booking = book;
                    }
                })
            })
        },
        onEditBooking() {
            console.log("edit", this.form)
            Axios.post("/api/updateBookingById/" + this.form.id, this.form).then((res) => {
                Axios.get("/api/getAllBookings").then((res) => {
                    var bb = res.data
                    var book = bb.filter((data) => data.user.id == this.user.id)
                    if (book == undefined) {
                        alert("Dont have booking.");
                    } else {
                        this.booking = book;
                    }
                })
            });

            this.dialog = false;
        },
        onOpenEdit(index) {
            this.dialog = true;
            this.form = index;
        }
    }
}
</script>

<style scoped>
.cen {
    display: block;
    margin-left: auto;
    margin-right: auto;
}

.card {
    padding: 5px;
    margin: 20px;
    overflow: hidden;
    height: 580px;
}

.roww {
    margin: -41px;
}

.img {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: auto;
    height: 250px;
}

h3 {
    font-family: "Merienda";
}
</style>
