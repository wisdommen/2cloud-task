<template>
  <v-card min-height="90">
    <v-card-text>
      <v-container class="d-flex align-self-center">
        <v-row class="justify-space-between">
          <v-col :cols="$vuetify.display.mdAndDown || grid_view ? '12' : '7'">
            <v-row class="pb-3">
              <strong class="mr-1">{{ carInfo.vehicleDescription }}</strong>
              <p>{{ carInfo.description }}</p>
            </v-row>
            <v-row v-if="$vuetify.display.mdAndUp && !grid_view">
              <v-chip class="rounded-lg mr-1" size="small">{{ carInfo.saleCategory }}</v-chip>
              <v-chip class="rounded-lg mr-1" size="small">{{ carInfo.odometer }} Kms</v-chip>
              <v-chip v-if="carInfo.branch" class="rounded-lg mr-1" size="small">{{ carInfo.branch }}</v-chip>
              <v-img
                :src="carInfo.overallCondition === 'Excellent' ?
              'good-condition.png' : (carInfo.overallCondition === 'Average' ?
              'average-condition.png' : 'poor-condition.png')"
                class="mr-1"
                max-width="30"
              />
              <p class="mr-1">{{ carInfo.overallCondition }} Condition</p>
              <svg id="event-24px" class="mr-1" height="24" viewBox="0 0 24 24"
                   width="24" xmlns="http://www.w3.org/2000/svg">
                <path id="Path_13" d="M0,0H24V24H0Z" data-name="Path 13" fill="none"></path>
                <path id="Path_14"
                      d="M17,12H12v5h5ZM16,1V3H8V1H6V3H5A1.991,1.991,0,0,0,3.01,5L3,19a2,2,0,0,0,2,2H19a2.006,2.006,0,0,0,2-2V5a2.006,2.006,0,0,0-2-2H18V1Zm3,18H5V8H19Z"
                      data-name="Path 14"
                      fill="#0098dc"></path>
              </svg>
              <p class="mr-1">{{ new Date(carInfo.soldDate).toLocaleString() }}</p>
            </v-row>
            <v-row v-if="$vuetify.display.mdAndDown || grid_view">
              <v-row class="pl-2 pb-2">
                <v-chip class="rounded-lg mr-1" size="small">{{ carInfo.saleCategory }}</v-chip>
                <v-chip class="rounded-lg mr-1" size="small">{{ carInfo.odometer }} Kms</v-chip>
                <v-chip v-if="carInfo.branch" class="rounded-lg mr-1" size="small">{{ carInfo.branch }}</v-chip>
              </v-row>
              <v-row class="pl-2 pb-2">
                <v-img
                  :src="
              carInfo.overallCondition === 'Excellent' ?
              'good-condition.png' : (carInfo.overallCondition === 'Average' ?
              'average-condition.png' : 'poor-condition.png')"
                  class="mr-1"
                  max-width="30"
                />
                <p class="mr-1">{{ carInfo.overallCondition }} Condition</p>
                <svg id="event-24px" class="mr-1" height="24" viewBox="0 0 24 24"
                     width="24" xmlns="http://www.w3.org/2000/svg">
                  <path id="Path_13" d="M0,0H24V24H0Z" data-name="Path 13" fill="none"></path>
                  <path id="Path_14"
                        d="M17,12H12v5h5ZM16,1V3H8V1H6V3H5A1.991,1.991,0,0,0,3.01,5L3,19a2,2,0,0,0,2,2H19a2.006,2.006,0,0,0,2-2V5a2.006,2.006,0,0,0-2-2H18V1Zm3,18H5V8H19Z"
                        data-name="Path 14"
                        fill="#0098dc"></path>
                </svg>
                <p class="mr-1">{{ new Date(carInfo.soldDate).toLocaleString() }}</p>
              </v-row>
            </v-row>
          </v-col>
          <v-col :cols="$vuetify.display.mdAndDown || grid_view ? '12' : '4'">
            <v-row class="d-flex justify-end">
              <v-col cols="12" lg="8" md="8" sm="8">
                <v-btn :block="true" class="btn button-text button-bg" variant="flat">
                  Subscribe to Reveal Price
                </v-btn>
              </v-col>
              <v-col cols="12" lg="4" md="4" sm="4">
                <CarDisplayLayer :carInfo="carInfo"/>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-container>
    </v-card-text>
  </v-card>
</template>

<script>
import CarDisplayLayer from "@/components/CarDisplayLayer.vue";

export default {
  name: "AppBar",
  components: {
    CarDisplayLayer
  },
  data: () => ({
    grid: false,
  }),
  props: {
    grid_view: {
      type: Boolean,
      required: false,
      default: false
    },
    carInfo: {
      type: Object,
      required: true
    }
  },
  methods: {}
}
</script>
<style>

</style>
