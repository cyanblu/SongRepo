<template>
  <div>
    <h1>Song List</h1>

    <router-link to="/create" class="create"> Neuen Song erstellen</router-link>


    <p> <!-- zeigt alles songs an die gefetcht werden von axios -->
      <div>
        <song v-for="song in songs" :href="song._links.self.href" :songProp="song"></song>
      </div>
    </p>

    <div class="pagination">
      <button @click="fetchSongs(0)" :disabled="pageNumber === 0">First Page</button>
      <button @click="fetchSongs(pageNumber - 1)" :disabled="pageNumber === 0">Previous</button>
      <span>Page {{ pageNumber + 1 }} of {{ totalPages }}</span>
      <button @click="fetchSongs(pageNumber + 1)" :disabled="pageNumber >= totalPages - 1">Next</button>
      <button @click="fetchSongs(totalPages - 1)" :disabled="pageNumber >= totalPages - 1">Last Page</button>
    </div>

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
      songs: [],
      pageNumber: 0,
      totalPages: 0,
      pageSize: 5
    };
  },
  computed: {
    paginatedSongs() {
      const start = (this.currentPage - 1) * this.songsPerPage;
      const end = start + this.songsPerPage;
      return this.songs.slice(start, end);
    }
  },
  mounted() {
    this.fetchSongs(this.pageNumber);
  },
  methods: {
    fetchSongs(page) {
      axios.get(`http://localhost:8080/api/songs?page=${page}&size=${this.pageSize}`)
          .then(response => {
            this.songs = response.data._embedded.songs;
            this.pageNumber = response.data.page.number;
            this.totalPages = response.data.page.totalPages;
            console.log(this.songs);
          })
          .catch(error => {
            console.error("There was an error fetching the songs:", error);
          });
    }
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
.pagination button {
  margin: 5px;
  padding: 5px;
}

</style>
