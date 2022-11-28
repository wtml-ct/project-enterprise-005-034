<template>
  <div>
    <div>
      <v-layout wrap>
        <v-flex lg3 md4 sm12 xs6 v-for="(b, idx) in this.booking" :key="idx" :items="booking">
          <v-card class="card">
            <div class="img">
              <img style="" class="text-center"
                :src="b.bookingBook.image" />
            </div>
            <v-card-title>{{ b.amount }}</v-card-title>
            <v-card-text>
              <div>Date : {{ b.date }}</div>
            </v-card-text>
            <v-btn outlined rounded text class="cen mb-5">
              EDIT
            </v-btn>
            <v-btn outlined rounded text class="cen mb-5" @click="onDeleteBooking(b)">
              DELETE
            </v-btn>
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
    };

  },
  computed: {},
  watch: {},
  mounted() {
  },
  created() {
    Axios.get("/api/getAllBookings").then((res) => {
      this.booking = res.data;
    })
  },

  beforeDestroy() {

  },
  methods: {
    onDeleteBooking(index) {
      console.log(index)
      Axios.delete("/api/deleteBookingById/" + index.id).then((res) => {
        Axios.get("/api/getAllBookings").then((res) => {
          this.booking = res.data;
        })
      })
      // Axios.get("/api/getAllBooks").then((res) => {
      //   var books = res.data;
      //   let b = [];
      //   for (var i = 0;i<books.length;i++){
      //     b.push(books[i].author.id);
      //   }
      //   console.log("books",b);

      // })

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