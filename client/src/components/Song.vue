<template>
  <div class="song">
    <h3>{{ songProp.title }}</h3>
    <p><strong>Artist:</strong> {{ songProp.artist }}</p>
    <p><strong>Genre:</strong> {{ songProp.genre }}</p>
    <p><strong>Length:</strong> {{ songProp.length }} minutes</p>
    <div class="button">
      <p>
        <button type="button" @click="">Edit</button>
      </p>
    </div>
    <p>({{href}})</p>
  </div>
</template>

<script>
export default {
  name: 'Song',
  props: {
    songProp: {
      type: Object,
      required: true
    },
    href: String
  }
}
</script>

<style scoped>
.song {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 20px;
  margin-bottom: 20px;
}
</style>
