<template>
  <div>
    <div v-if="step == 0">
      <v-layout wrap>
        <v-flex lg3 md4 sm12 xs6 v-for="(b, idx) in this.book" :key="idx" :items="book">
          <v-card class="card">
            <div class="img">
              <img style="" class="text-center" :src="b.image" />
            </div>
            <v-card-title>{{ b.title }}</v-card-title>
            <v-card-text>
              <div>ID : {{ b.id }}</div>
              <div>Book : {{ b.description }}</div>
              <div>Author : {{ b.author.name }}</div>
            </v-card-text>
            <v-btn outlined rounded class="cen mb-5" style="color:green" @click="onOpenBook(b)">
              BOOKING
            </v-btn>
            <v-dialog v-model="dialog" persistent max-width="600px">
              <v-card>
                <v-card-title>
                  <span class="text-h5">Add Date</span>
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
                  <v-btn color="blue darken-1" text @click="onBooking()">
                    Save
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
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
  name: 'History',
  data() {
    return {
      author: [],
      book: [],
      step: 0,
      form: {
        date: "",
        id:""
      },
      user:"",
      dialog: false,
    };

  },
  computed: {},
  watch: {},
  mounted() {
  },
  created() {
    Axios.get("/api/getAllBooks").then((res) => {
      this.book = res.data;
    })
    this.user = JSON.parse(sessionStorage.getItem("users"))
  },
  beforeDestroy() {

  },
  methods: {
    onBooking() {
      Axios.post("/api/addBooking", {
        date: this.form.date,
        user: { id: this.user.id },
        bookingBook: { id: this.form.id }
      })
      this.$router.push({ path: "/History" });
    },
    onOpenBook(index) {
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