<template>
  <div>
    <p class="mt-2 text-center" style="font-weight: 700; font-size: 250%;">History</p>
    <div>
      <v-layout wrap>
        <v-flex lg3 md4 sm12 xs6 v-for="(b, idx) in this.booking" :key="idx" :items="booking">
          <v-card class="card">
            <div class="img">
              <img style="" class="text-center" :src="b.bookingBook.image" />
            </div>
            <v-card-title>{{ b.bookingBook.title }}</v-card-title>
            <v-card-title>{{ b.user.name }}</v-card-title>
            <v-card-text>
              <div>Date : {{ b.date }}</div>
            </v-card-text>
            <v-row class="bottom">
            <v-btn outlined rounded class="cen mb-5" style="color:orange" @click="onOpenEdit(b)">
              EDIT
            </v-btn>
            <v-dialog v-model="dialog" persistent max-width="600px">
              <v-card>
                <v-card-title>
                  <span class="text-h5">Edit Date</span>
                </v-card-title>
                <v-card-text>
                  <v-container>
                    <v-row>
                      <v-text-field v-model.trim="form.date" label="Date"></v-text-field>
                    </v-row>
                  </v-container>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="dialog = false">
                    Close
                  </v-btn>
                  <v-btn color="blue darken-1" text @click="onEditBooking()">
                    Save
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
            <v-btn outlined rounded class="cen mb-5" style="color:red" @click="onDeleteBooking(b)">
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
  component: {
  },
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
  mounted() {
  },
  created() {
    this.user = JSON.parse(sessionStorage.getItem("users"))
    Axios.get("/api/getAllBookings").then((res) => {
        this.booking = res.data;
    })
  },

  beforeDestroy() {

  },
  methods: {
    onDeleteBooking(index) {
      console.log(index.id)
      Axios.delete("/api/deleteBookingById/" + index.id).then((res) => {
        Axios.get("/api/getAllBookings").then((res) => {
          this.booking = res.data;
        })
      })
    },
    onEditBooking() {
      console.log("edit", this.form)
      Axios.post("/api/updateBookingById/" + this.form.id, this.form).then((res) => {
        Axios.get("/api/getAllBookings").then((res) => {
          this.booking = res.data;
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
<style>
.cen {
  display: block;
  margin-left: auto;
  margin-right: auto;
}

.card {
  margin: 20px;
  overflow: hidden;
}

img {
  width: auto;
  height: 250px;
}
</style>