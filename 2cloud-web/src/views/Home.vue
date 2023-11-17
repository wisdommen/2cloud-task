<template>
  <v-container>
    <v-row>
      <v-col>
        <div class="text-h4 font-weight-bold hidden-small">
          Search Used Car Prices
        </div>
        <div class="text-h5 font-weight-bold hidden-large">
          Search Used Car Prices
        </div>
      </v-col>
    </v-row>
    <v-row>
      <SearchFilters class="hidden-small mb-n5" @search="setFilter" @clear="clear"/>
    </v-row>
    <v-row>
      <CurrentStatics :name="search_filter" :record_count="100" :avg_age="100" :avg_km="12" :avg_price="200" class="pl-5"
                      @viewModeChange="changeViewMode" @search="setFilter" @clear="clear"/>
    </v-row>
    <v-row>
      <Banner class="mx-2"/>
    </v-row>
    <v-row class="d-flex">
      <v-col v-if="this.items.length === 0">
        <v-img src="search-empty.png" max-height="130px" class="justify-center"></v-img>
        <p class="justify-center text-center pa-5 text-h6 font-weight-bold">No records available</p>
      </v-col>
      <v-col v-else>
        <v-infinite-scroll
          @load="load"
          class="overflow-x-hidden"
        >
          <v-row>
            <template v-for="(item, index) in items" :key="index">
              <v-col :cols="$vuetify.display.mdAndUp && grid_view ? '4' : '12'">
                <CarInfoCard :grid_view="grid_view" :carInfo="item"/>
              </v-col>
            </template>
          </v-row>
        </v-infinite-scroll>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import SearchFilters from "@/components/SearchFilters.vue";
import CurrentStatics from "@/components/CurrentStatics.vue";
import Banner from "@/components/Banner.vue";
import CarInfoCard from "@/components/CarInfoCard.vue";
import request from "@/js/request";

export default {
  name: "Home",
  components: {
    SearchFilters,
    CurrentStatics,
    Banner,
    CarInfoCard
  },
  data: () => ({
    items: [],
    grid_view: false,
    search_filter: null
  }),
  methods: {
    setFilter(value) {
      this.items = []
      this.search_filter = value
      request.base.get('/car', {
        params: this.search_filter
      }).then((response) => {
        this.items = response.data.data.records
        this.search_filter.page += 1
      })
    },
    load({done}) {
      request.base.get('/car', {
        params: this.search_filter
      }).then((response) => {
        if (this.items.length >= response.data.data.total) {
          done('empty')
          return;
        }
        this.items.push(...response.data.data.records)
        done('ok')
      })
    },
    changeViewMode(value) {
      this.grid_view = value
    },
    clear() {
      this.items = []
      this.search_filter = null
    }
  },
  watch: {
    'grid_view': {
      handler: function () {
        console.log(this.grid_view)
      }
    }
  }
}
</script>
