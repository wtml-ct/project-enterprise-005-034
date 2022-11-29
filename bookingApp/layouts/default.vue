<template>
  <v-app dark>
      <v-app-bar color="blue-grey lighten-4" fixed app>
          <!-- <v-app-bar-nav-icon @click.stop="drawer = !drawer" /> -->
          <!-- <v-btn icon @click.stop="miniVariant = !miniVariant"> -->
          <!-- <v-icon>mdi-{{ `chevron-${miniVariant ? 'right' : 'left'}` }}</v-icon> -->
          <!-- </v-btn> -->
  
          <v-toolbar-title>
              <h2 style="font-family:Merienda;" class="ml-6">{{ title }} </h2>
          </v-toolbar-title>
          <v-spacer />
          <v-btn class="ma-2" outlined color="" href="/Bookingbook">
              Add Booking
          </v-btn>
          <v-btn class="ma-2" outlined color="" href="/history">
              My Booking
          </v-btn>
          <v-btn color="red" icon href="/">
              <v-icon>mdi-logout</v-icon>
          </v-btn>
      </v-app-bar>
      <v-main>
          <v-container>
              <Nuxt />
          </v-container>
      </v-main>
  </v-app>
  </template>
  
      
  <script>
  export default {
      components: {
          
      },
      name: 'DefaultLayout',
      data() {
          return {
              title: 'BookingBook'
          }
      }
  }
  </script>
  