<template>
  <div>
    <h2>YoutubeView</h2>
    <YoutubeVideoSearch />
    <hr>
    <YoutubeVideoDetail/>
    <hr />
    <YoutubeVideoList />
  </div>
</template>

<script setup>
import YoutubeVideoSearch from '@/components/youtube/YoutubeVideoSearch.vue';
import YoutubeVideoList from '@/components/youtube/YoutubeVideoList.vue';
import YoutubeVideoDetail from '../components/youtube/YoutubeVideoDetail.vue';
</script>

<style scoped></style>
