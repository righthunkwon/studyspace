import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'


export const useYoutubeStore = defineStore('youtube', () => {
  const videos = ref([])
  const selectedVideo = ref(null)

  const youtubeSearch = function(keyword){
    const URL = 'https://www.googleapis.com/youtube/v3/search';
    const API_KEY = 'AIzaSyDOR1XzCTQPrKFzzqWTUUQgkwOoCCyBCOg'
    axios({
      url: URL,
      method: "GET",
      params: {
        key: API_KEY,
        part: "snippet",
        q: keyword,
        type: 'video',
        maxResults: 10
      }
    })
    .then((response)=>{
      videos.value = response.data.items
    })
    .catch(()=>{})
  }

  const clickVideo = function(video){
    selectedVideo.value = video
  }
  return { videos, youtubeSearch, clickVideo, selectedVideo }
})
