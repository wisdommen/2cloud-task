<template>
  <v-container>
    <v-row class="justify-space-between px-3 hidden-md-and-down" v-if="name">
      <v-row>
        <div class="row align-self-center bg-blue px-5 py-2">
          {{ name.make }} {{ name.model}} Stats:
        </div>
        <div class="row align-self-center px-5 py-2 bg-white">
          <svg xmlns="http://www.w3.org/2000/svg" width="17" height="14" viewBox="0 0 17 14" class="align-self-center pr-1">
            <path id="Path_8" data-name="Path 8"
                  d="M4,14H8V10H4Zm0,5H8V15H4ZM4,9H8V5H4Zm5,5H21V10H9Zm0,5H21V15H9ZM9,5V9H21V5Z"
                  transform="translate(-4 -5)" fill="#8e969e"></path>
          </svg>
          <p>Records: {{ record_count }}</p>
        </div>
        <div class="row align-self-center px-5 py-2 bg-white">
          <svg xmlns="http://www.w3.org/2000/svg" width="22.984" height="23" viewBox="0 0 22.984 23" class="align-self-center pr-1">
            <path id="Path_9" data-name="Path 9"
                  d="M22.993,4.412a12.756,12.756,0,0,1-1.587,6.139.683.683,0,0,1-1.167-.709,11.566,11.566,0,0,0,1.389-5.43A2.805,2.805,0,0,0,18.9,1.365,2.733,2.733,0,0,0,16.168,4.1a21.589,21.589,0,0,0,.43,2.846.683.683,0,0,1-1.336.279A22.44,22.44,0,0,1,14.8,4.1,4.1,4.1,0,0,1,18.9,0,4.168,4.168,0,0,1,22.993,4.412ZM19.013,5.486c.271,2.268.665,6.688.213,7.138L9.308,22.542a1.562,1.562,0,0,1-2.21,0L.466,15.911a1.563,1.563,0,0,1,0-2.21l9.919-9.918a14.78,14.78,0,0,1,3.8-.064c-.011.127-.038.247-.038.377a13.511,13.511,0,0,0,.224,1.936A1.877,1.877,0,1,0,17,5.543a11.44,11.44,0,0,1-.18-1.447c0-.061.012-.117.018-.176.238.025.472.051.693.078C18.84,4.159,18.853,4.156,19.013,5.486Zm-5.286,7.423a4.276,4.276,0,0,0-.966-1.532l.753-.754-.838-.837-.812.813a2.219,2.219,0,0,0-2.969.077c-.829.829-.634,1.882-.025,3.105.418.847.495,1.335.17,1.659s-.872.189-1.361-.3a4.269,4.269,0,0,1-1.043-1.8l-1.258.746A4.9,4.9,0,0,0,6.472,15.9l-.82.821.837.838.882-.881a2.3,2.3,0,0,0,3.1-.051c.779-.78.847-1.652.18-3.038-.463-.993-.574-1.481-.3-1.754.24-.24.667-.309,1.223.247a3.762,3.762,0,0,1,.933,1.532Z"
                  transform="translate(-0.008)" fill="#8e969e"></path>
          </svg>
          <p>Avg Price: {{ avg_price }}</p>
        </div>
        <div class="row align-self-center px-5 py-2 bg-white">
          <svg xmlns="http://www.w3.org/2000/svg" width="30.094" height="16" viewBox="0 0 30.094 16" class="align-self-center pr-1">
            <g id="meter" transform="translate(0 -55.477)">
              <path id="Path_10" data-name="Path 10"
                    d="M25.767,59.976a.978.978,0,0,0-.08-.092.992.992,0,0,0-.091-.08,15,15,0,0,0-10.547-4.328h0A15,15,0,0,0,4.5,59.8a.942.942,0,0,0-.091.08.959.959,0,0,0-.08.092A15,15,0,0,0,0,70.524a.953.953,0,0,0,.953.953H29.142a.953.953,0,0,0,.953-.953A15,15,0,0,0,25.767,59.976Zm-6.883,9.6h-.643A3.336,3.336,0,0,0,17.227,68l.281-.57A3.962,3.962,0,0,1,18.884,69.572Zm-3.4-2.351a3.328,3.328,0,0,0-3.636,2.351H11.21a3.949,3.949,0,0,1,4.566-2.933Zm4.694,2.351a5.231,5.231,0,0,0-2.1-3.3l2.278-4.619a.953.953,0,0,0-1.709-.843l-2.3,4.653a5.225,5.225,0,0,0-6.443,4.106H1.94a13.085,13.085,0,0,1,3.17-7.637l.65.65a.953.953,0,0,0,1.348-1.347l-.65-.65a13.086,13.086,0,0,1,7.637-3.17V58.5A.953.953,0,0,0,16,58.5V57.417a13.087,13.087,0,0,1,7.637,3.17l-.65.65a.953.953,0,0,0,1.348,1.347l.65-.65a13.085,13.085,0,0,1,3.17,7.637H20.183Z"
                    fill="#8e969e"></path>
            </g>
          </svg>
          <p>Avg KM: {{ avg_km }} kms</p>
        </div>
        <div class="row align-self-center px-5 py-2 bg-white">
          <svg id="calendar_today-24px_1_" data-name="calendar_today-24px (1)"
               xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" class="align-self-center pr-1">
            <path id="Path_11" data-name="Path 11" d="M0,0H24V24H0Z" fill="none"></path>
            <path id="Path_12" data-name="Path 12"
                  d="M20,3H19V1H17V3H7V1H5V3H4A2.006,2.006,0,0,0,2,5V21a2.006,2.006,0,0,0,2,2H20a2.006,2.006,0,0,0,2-2V5A2.006,2.006,0,0,0,20,3Zm0,18H4V8H20Z"
                  fill="#8e969e"></path>
          </svg>
          <p>
            Avg Age: {{ avg_age }} months
          </p>
        </div>
      </v-row>
      <div class="d-flex align-self-center px-5 py-2">
        <v-btn-toggle v-model="grid_view" mandatory>
          <v-btn :value="false">
            <v-icon>mdi-view-list</v-icon>
          </v-btn>
          <v-btn :value="true">
            <v-icon>mdi-view-grid</v-icon>
          </v-btn>
        </v-btn-toggle>
      </div>
    </v-row>
    <v-container class="hidden-md-and-up mx-n7 mt-n7">
      <v-row class="d-flex" style="width: 100vw">
        <v-col cols="12" class="bg-blue">
          <v-row class="d-flex justify-space-between">
            <div class="align-self-center pl-4" v-if="name">
              {{ name.make }} {{ name.model}} Stats:
            </div>
            <v-btn variant="text" class="btn" @click="openFilters = !openFilters" :ripple="false">
              <v-icon>mdi-filter</v-icon>
              Filters
            </v-btn>
          </v-row>
        </v-col>
      </v-row>
      <v-row class="bg-white d-flex" style="width: 100vw" v-if="name">
        <v-col class="px-5 py-2 bg-white align-self-center">
          <v-row class="row">
            <svg xmlns="http://www.w3.org/2000/svg" width="17" height="14" viewBox="0 0 17 14" class="align-self-center pr-1">
              <path id="Path_8" data-name="Path 8"
                    d="M4,14H8V10H4Zm0,5H8V15H4ZM4,9H8V5H4Zm5,5H21V10H9Zm0,5H21V15H9ZM9,5V9H21V5Z"
                    transform="translate(-4 -5)" fill="#8e969e"></path>
            </svg>
            <p style="font-size: small" class="align-self-center">Records: {{ record_count }}</p>
          </v-row>
        </v-col>
        <v-col class="px-5 py-2 bg-white align-self-center">
          <v-row class="row">
            <v-col cols="1" class="ml-n3">
              <svg xmlns="http://www.w3.org/2000/svg" width="22.984" height="23" viewBox="0 0 22.984 23" class="align-self-center pr-1">
                <path id="Path_9" data-name="Path 9"
                      d="M22.993,4.412a12.756,12.756,0,0,1-1.587,6.139.683.683,0,0,1-1.167-.709,11.566,11.566,0,0,0,1.389-5.43A2.805,2.805,0,0,0,18.9,1.365,2.733,2.733,0,0,0,16.168,4.1a21.589,21.589,0,0,0,.43,2.846.683.683,0,0,1-1.336.279A22.44,22.44,0,0,1,14.8,4.1,4.1,4.1,0,0,1,18.9,0,4.168,4.168,0,0,1,22.993,4.412ZM19.013,5.486c.271,2.268.665,6.688.213,7.138L9.308,22.542a1.562,1.562,0,0,1-2.21,0L.466,15.911a1.563,1.563,0,0,1,0-2.21l9.919-9.918a14.78,14.78,0,0,1,3.8-.064c-.011.127-.038.247-.038.377a13.511,13.511,0,0,0,.224,1.936A1.877,1.877,0,1,0,17,5.543a11.44,11.44,0,0,1-.18-1.447c0-.061.012-.117.018-.176.238.025.472.051.693.078C18.84,4.159,18.853,4.156,19.013,5.486Zm-5.286,7.423a4.276,4.276,0,0,0-.966-1.532l.753-.754-.838-.837-.812.813a2.219,2.219,0,0,0-2.969.077c-.829.829-.634,1.882-.025,3.105.418.847.495,1.335.17,1.659s-.872.189-1.361-.3a4.269,4.269,0,0,1-1.043-1.8l-1.258.746A4.9,4.9,0,0,0,6.472,15.9l-.82.821.837.838.882-.881a2.3,2.3,0,0,0,3.1-.051c.779-.78.847-1.652.18-3.038-.463-.993-.574-1.481-.3-1.754.24-.24.667-.309,1.223.247a3.762,3.762,0,0,1,.933,1.532Z"
                      transform="translate(-0.008)" fill="#8e969e"></path>
              </svg>
            </v-col>
            <v-col>
              <p style="font-size: small" class="align-self-center">
                Avg Price:
                <span class="text-blue-lighten-1">Subscribe to Reveal Price</span>
              </p>
            </v-col>
          </v-row>
        </v-col>
      </v-row>
      <v-row class="bg-white d-flex" style="width: 100vw" v-if="name">
        <v-col class="px-5 py-2 bg-white align-self-center">
          <v-row class="row">
            <svg xmlns="http://www.w3.org/2000/svg" width="30.094" height="16" viewBox="0 0 30.094 16" class="align-self-center pr-1">
              <g id="meter" transform="translate(0 -55.477)">
                <path id="Path_10" data-name="Path 10"
                      d="M25.767,59.976a.978.978,0,0,0-.08-.092.992.992,0,0,0-.091-.08,15,15,0,0,0-10.547-4.328h0A15,15,0,0,0,4.5,59.8a.942.942,0,0,0-.091.08.959.959,0,0,0-.08.092A15,15,0,0,0,0,70.524a.953.953,0,0,0,.953.953H29.142a.953.953,0,0,0,.953-.953A15,15,0,0,0,25.767,59.976Zm-6.883,9.6h-.643A3.336,3.336,0,0,0,17.227,68l.281-.57A3.962,3.962,0,0,1,18.884,69.572Zm-3.4-2.351a3.328,3.328,0,0,0-3.636,2.351H11.21a3.949,3.949,0,0,1,4.566-2.933Zm4.694,2.351a5.231,5.231,0,0,0-2.1-3.3l2.278-4.619a.953.953,0,0,0-1.709-.843l-2.3,4.653a5.225,5.225,0,0,0-6.443,4.106H1.94a13.085,13.085,0,0,1,3.17-7.637l.65.65a.953.953,0,0,0,1.348-1.347l-.65-.65a13.086,13.086,0,0,1,7.637-3.17V58.5A.953.953,0,0,0,16,58.5V57.417a13.087,13.087,0,0,1,7.637,3.17l-.65.65a.953.953,0,0,0,1.348,1.347l.65-.65a13.085,13.085,0,0,1,3.17,7.637H20.183Z"
                      fill="#8e969e"></path>
              </g>
            </svg>
            <p style="font-size: small" class="align-self-center">Avg KM: {{ avg_km }} kms</p>
          </v-row>
        </v-col>
        <v-col class="px-5 py-2 bg-white">
          <v-row class="row">
              <svg id="calendar_today-24px_1_" data-name="calendar_today-24px (1)"
                   xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" class="align-self-center pr-1">
                <path id="Path_11" data-name="Path 11" d="M0,0H24V24H0Z" fill="none"></path>
                <path id="Path_12" data-name="Path 12"
                      d="M20,3H19V1H17V3H7V1H5V3H4A2.006,2.006,0,0,0,2,5V21a2.006,2.006,0,0,0,2,2H20a2.006,2.006,0,0,0,2-2V5A2.006,2.006,0,0,0,20,3Zm0,18H4V8H20Z"
                      fill="#8e969e"></path>
              </svg>
              <p style="font-size: small" class="align-self-center">
                Avg Age: {{ avg_age }} months
              </p>
          </v-row>
        </v-col>
      </v-row>
      <v-row style="width: 100vw" class="d-flex justify-center pt-3">
          <v-btn class="btn bg-blue-lighten-1" variant="flat" width="94vw">
            Subscribe to Generate Summary Report
          </v-btn>
      </v-row>
    </v-container>
    <v-overlay v-model="openFilters">
      <v-sheet style="width: 65vw" class="overflow-y-auto" max-height="100vh" elevation="20">
        <SearchFilters @search="setFilter" @clear="clear"/>
      </v-sheet>
    </v-overlay>
  </v-container>
</template>

<script>
import SearchFilters from "@/components/SearchFilters.vue";

export default {
  name: "CurrentStatics",
  components: {SearchFilters},
  data: () => ({
    grid_view: false,
    openFilters: false,
    filters: null
  }),
  props: {
    name: {
      type: String,
      default: ''
    },
    record_count: {
      type: Number,
      default: 0
    },
    avg_price: {
      type: Number,
      default: 0
    },
    avg_km: {
      type: Number,
      default: 0
    },
    avg_age: {
      type: Number,
      default: 0
    }
  },
  methods: {
    setFilter(value) {
      this.openFilters = false
      this.$emit('search', value)
    },
    clear() {
      this.openFilters = false
      this.$emit('clear')
    },
  },
  watch: {
    'grid_view': {
      handler: function () {
        this.$emit('viewModeChange', this.grid_view)
      }
    }
  }
}
</script>

<style>
.row {
  min-height: 40px;
  display: flex;
}
</style>
