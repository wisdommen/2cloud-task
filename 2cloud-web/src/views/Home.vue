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
      <SearchFilters class="hidden-small mb-n5"/>
    </v-row>
    <v-row>
      <CurrentStatics name="Audi" :record_count="100" :avg_age="100" :avg_km="12" :avg_price="200" class="pl-5" @viewModeChange="changeViewMode"/>
    </v-row>
    <v-row>
      <Banner class="mx-2"/>
    </v-row>
    <v-row>
      <v-col>
        <v-infinite-scroll
          mode="manual"
          @load="load"
        >
          <v-row>
            <template v-for="(item, index) in items" :key="index">
              <v-col :cols="$vuetify.display.mdAndUp && grid_view ? '4' : '12'">
                <CarInfoCard :grid_view="grid_view"/>
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
      grid_view: false
    }),
    methods: {
      load ({ done }) {
        setTimeout(() => {

          this.items.push(...Array.from({ length: 10 }, (k, v) => v + this.items.at(-1) + 1))

          done('ok')
        }, 1000)
      },
      changeViewMode (value) {
        this.grid_view = value
      }
    },
    watch:{
      'grid_view': {
        handler: function () {
          console.log(this.grid_view)
        }
      }
    }
  }
</script>
