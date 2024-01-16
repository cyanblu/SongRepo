<template>

  <p>Message is: {{ message }}</p>
  <input v-model="message" placeholder="edit me" />

  <button type="submit" @click="createFunction">Song erstellen</button>

</template>


<script>
import axios from "axios";
import Song from "@/components/Song.vue";
export default {
  name: 'SongList',
  components: {
    Song
  },
  data() {
    return {
      songs: []
    };
  },
  mounted() {
    axios.post('http://localhost:8080/api/songs', {}, )
        /*.then(response => {
          this.songs = response.data._embedded.songs;
          console.log(this.songs)
        })
        .catch(error => {
          console.error("There was an error fetching the songs:", error);
        });*/
  }
}
</script>

