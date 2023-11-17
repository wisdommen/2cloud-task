<template>
  <v-btn class="btn" :block="true" variant="outlined" color="primary" @click="overlay = true">
    See More
  </v-btn>

  <v-overlay v-model="overlay" class="d-flex justify-center align-items-center">
      <v-card class="overflow-y-auto fixed-width-card pl-5 elevation-20" max-height="800" style="width: 90vw">
            <v-container>
              <v-row class="d-flex">
                <v-col class="d-flex me-auto">
                  <v-row class="d-flex">
                    <span class="text-h5 font-weight-bold me-auto align-self-center">Vehicle Condition Report</span>
                    <v-btn class="btn button-text button-bg align-self-center" width="200" variant="flat">
                      Subscribe to Reveal Price
                    </v-btn>
                  </v-row>
                </v-col>
                <v-col cols="1" class="d-flex">
                  <v-btn icon variant="plain" @click="overlay = false"><v-icon>mdi-close</v-icon></v-btn>
                </v-col>
              </v-row>
              <v-row>
                <v-col>
                  <table class="vehicle-info-table">
                    <tbody>
                    <tr v-for="(value, key) in vehicleInfo" :key="key">
                      <td class="label">{{ key }}</td>
                      <td class="value">{{ value }}</td>
                    </tr>
                    </tbody>
                  </table>
                </v-col>
              </v-row>
              <v-row>
                <p class="text-h6 font-weight-bold">Vehicle Condition</p>
              </v-row>
              <v-row>
                <v-chip
                  color="white"
                  class="rounded ma-1"
                  style="background: #ff5a60!important;"
                  v-for="(item, key) in conditionDescription.split(',')"
                  :key="key"
                >
                  <div class="text-white">{{item}}</div>
                </v-chip>
              </v-row>
              <v-row class="d-flex">
                <v-col cols="12" sm="12" md="6" lg="6">
                  <v-row>
                <span class="text-h6 font-weight-bold align-self-center" >
                  Tyre Condition
                </span>
                  </v-row>
                  <v-row>
                    <table class="vehicle-tyre-table">
                      <tbody>
                      <tr v-for="(value, key) in tyreCondition" :key="key">
                        <td class="label">{{ key }}</td>
                        <td class="value">{{ value }}</td>
                      </tr>
                      </tbody>
                    </table>
                  </v-row>
                </v-col>
                <v-col cols="12" sm="12" md="6" lg="6">
                  <v-row>
                    <span class="text-h6 font-weight-bold align-self-center" >
                      Keys & Books
                    </span>
                  </v-row>
                  <v-row>
                    <table class="vehicle-tyre-table">
                      <tbody>
                      <tr v-for="(value, key) in keysAndBooks" :key="key">
                        <td class="label">{{ key }}</td>
                        <td class="value">{{ value }}</td>
                      </tr>
                      </tbody>
                    </table>
                  </v-row>
                </v-col>
              </v-row>
            </v-container>
      </v-card>
  </v-overlay>
</template>

<script>
export default {
  name: "AppBar",
  data: () => ({
    overlay: false,
    vehicleInfo: {
      'Make': 'Audi',
      'Model': 'A1',
      'Year': '2012',
      'Description': '8X MY12 Ambition Hatchback 3dr Man 6sp 1.4T',
      'Colour': 'Silver',
      'Engine': '1.4 Direct Injection Turbo Petrol',
      'Transmission': '6 Ambition Manual',
      'Odometer': '97,600 Kms',
      'Sale Date': 'Friday, November 10, 2023',
      'Accessories': '--',
      'Auction Information': '--'
    },
    conditionDescription: 'Minor Dents ,Minor Scrapes ,Joint Trim Missing ,Seat Stained ,Seat Stained ,Owners Manual Missing ,Partial/Incomplete Service History ,Minor Dents ,Minor Paint Chips/Scratches All Over ,Previous Paint Repair Evident ,Alloy Wheel Scraped ,Alloy Wheel Scraped ,Alloy Wheel Scraped ,Alloy Wheel Scraped ,Pitted ,Loose/Unclipped ,Loose/Unclipped ,Chipped Edges ,Previous Paint Repairs Evident ,Chipped Edges ,Minor Dents ,Sagging/Unclipped ,Stained/Soiled ,Torn/Ripped/Holes ,Spare Key With Integrated Remote Missing ,Mechanical Issues Evident - Requires Diagnosis ,Minor Dents ,Previous Paint Repairs Evident ',
    tyreCondition: {
      "Left Front":	'--',
      "Left Rear":	'--',
      "Right Front": '--',
      "Right Rear":	'--',
      "Spare": '--'
    },
    keysAndBooks: {
      "Log Books": '--',
      "Owners Manual": '--',
      "Keys": '--',
    }
  }),
  props:{
    carInfo: {
      type: Object,
      required: true
    }
  },
  methods:{
  }
}
</script>

<style>
.fixed-width-card {
  width: 100%;
}

@media (min-width: 1000px) {
  .fixed-width-card {
    width: 1000px;
  }
}


.vehicle-info-table .label {
  font-weight: bold;
  text-align: left;
  background: #f5f5f5;
  max-width: 160px;
}
.vehicle-info-table .value {
  text-align: left;
  width: 100%;
}
.vehicle-info-table td {
  padding: 8px;
  border: 1px solid #ddd;
  border-collapse: collapse;
}

.vehicle-tyre-table {
  width: 95%;
}
.vehicle-tyre-table .label {
  font-weight: bold;
  text-align: left;
  background: #f5f5f5;
  width: 50%;
}
.vehicle-tyre-table .value {
  text-align: left;
  width: 50%;
}
.vehicle-tyre-table td {
  padding: 8px;
  border: 1px solid #ddd;
  border-collapse: collapse;
}

table {
  border-collapse: collapse;
}


</style>
