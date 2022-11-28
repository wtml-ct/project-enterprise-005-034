<template>
  <div>
    <div v-if="step == 0">
      <v-layout wrap>
        <v-flex lg3 md4 sm12 xs6 v-for="(b, idx) in this.book" :key="idx" :items="book">
          <v-card class="card">
            <div class="img">
              <img style="" class="text-center" :src="b.image" />
            </div>
            <v-card-title>{{ b.description }}</v-card-title>
            <v-card-text>
              <div>ID : {{ b.id }}</div>
              <div>Book : {{ b.title }}</div>
              <div>Author : {{ b.author.id }}</div>
            </v-card-text>
            <v-btn outlined rounded text class="cen mb-5" @click="onBooking(b)">
              BOOKING
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
  name: 'History',
  data() {
    return {
      author: [],
      book: [],
      step: 0,
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
  },
  beforeDestroy() {

  },
  methods: {
    onBooking(index) {
      Axios.post("/api/addBooking", {
        date: "12",
        amount: "43",
        user: { id: 1 },
        bookingBook: { id: index.id }
      })
      this.$router.push({ path: "/History" });

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