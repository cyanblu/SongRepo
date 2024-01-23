<template>

  <p>Message is: {{ message }}</p>
  <input type="text" v-model="title" placeholder="title" />
  <input type="text" v-model="artist" placeholder="artist" />
  <input type="text" v-model="genre" placeholder="genre" />
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
      newSong: {  //da diese Variable aufgelöst wird werden nur die Attribute weitergegeben
        title: '',
        artist: '',
        genre: '',
        // any other song properties

        createFunction() {
          axios.post('http://localhost:8080/api/songs', this.newSong)
              .then(response => {
                this.songs.push(response.data);
                this.newSong = {  //da diese Variable aufgelöst wird werden nur die Attribute weitergegeben
                  title: '',
                  artist: '',
                  genre: '',
                  // any other song properties
                }
              })
              .catch(error => {
                console.error("There was an error creating the song:", error);
              });
        }
      }
    };
  },
  mounted() {
    //axios.post('http://localhost:8080/api/songs', {}, )
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

