<template>
  <div>
    <h1>Song List</h1>

    <router-link to="/create" class="create"> Neuen Song erstellen</router-link>


    <p>
      <div>
        <song v-for="song in songs" :href="song._links.self.href" :songProp="song"></song>
      </div>
    </p>
  </div>
</template>

<script>
import axios from 'axios';
import Song from './Song.vue';

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
    axios.get('http://localhost:8080/api/songs')
        .then(response => {
          this.songs = response.data._embedded.songs;
          console.log(this.songs)
        })
        .catch(error => {
          console.error("There was an error fetching the songs:", error);
        });
  }
}
</script>

<style>

.create {
  border: 3px solid black;
  border-radius: 4px;
  padding: 10px;
  background-color: bisque;
}

</style>
