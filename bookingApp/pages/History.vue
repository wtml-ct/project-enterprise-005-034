<template>
  <div>
    <v-layout wrap>
      <v-flex lg3 md4 sm12 xs6 v-for="(au, idx) in this.author" :key="idx" :items="author">
        <v-card class="card">
          <div class="img">
            <img style="" class="text-center" :src="au.pic" />
          </div>
          <v-card-title>{{ au.name }}</v-card-title>
          <v-card-text>
            <div>Author : {{ au.name }}</div>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
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
    };

  },
  computed: {},
  watch: {},
  mounted() {
  },
  created() {
    Axios.get("/api/getAllAuthors").then((res) => {
      this.author = res.data
      console.log(this.author)
    })
  },
  beforeDestroy() {

  },
  methods: {
   
  }
}
</script>
<style>
.card {
  margin: 20px;
  overflow: hidden;
}

img {
  width: auto;
  height: 250px;
}
</style>