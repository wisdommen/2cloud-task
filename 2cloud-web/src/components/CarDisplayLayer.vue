<template>
  <v-btn :block="true" class="btn" color="primary" variant="outlined" @click="overlay = true">
    See More
  </v-btn>

  <v-overlay v-model="overlay" class="d-flex justify-center align-items-center">
    <v-card class="overflow-y-auto fixed-width-card pl-5 elevation-20" max-height="800" style="width: 90vw">
      <v-container>
        <v-row class="d-flex">
          <v-col class="d-flex me-auto">
            <v-row class="d-flex">
              <span class="text-h5 font-weight-bold me-auto align-self-center">Vehicle Condition Report</span>
              <v-btn class="btn button-text button-bg align-self-center" variant="flat" width="200">
                Subscribe to Reveal Price
              </v-btn>
            </v-row>
          </v-col>
          <v-col class="d-flex" cols="1">
            <v-btn icon variant="plain" @click="overlay = false">
              <v-icon>mdi-close</v-icon>
            </v-btn>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <table class="vehicle-info-table">
              <tbody>
              <tr>
                <td class="label">Make</td>
                <td class="value">{{ carInfo.make ? carInfo.make : '--' }}</td>
              </tr>
              <tr>
                <td class="label">Model</td>
                <td class="value">{{ carInfo.model ? carInfo.model : '--' }}</td>
              </tr>
              <tr>
                <td class="label">Year</td>
                <td class="value">{{ carInfo.yearGroup ? carInfo.yearGroup : '--' }}</td>
              </tr>
              <tr>
                <td class="label">Description</td>
                <td class="value">{{ carInfo.description ? carInfo.description : '--' }}</td>
              </tr>
              <tr>
                <td class="label">Colour</td>
                <td class="value">{{ carInfo.colour ? carInfo.colour : '--' }}</td>
              </tr>
              <tr>
                <td class="label">Engine</td>
                <td class="value">
                  {{
                    carInfo.engineDescription + ' ' + carInfo.fuelDeliveryDescription + ' ' + carInfo.inductionDescription + ' ' + carInfo.fuelTypeDescription
                  }}
                </td>
              </tr>
              <tr>
                <td class="label">Transmission</td>
                <td class="value">
                  {{ carInfo.gearNum + ' ' + carInfo.badgeDescription + ' ' + carInfo.gearTypeDescription }}
                </td>
              </tr>
              <tr>
                <td class="label">Odometer</td>
                <td class="value">{{ carInfo.odometer ? carInfo.odometer + ' Kms' : '--' }}</td>
              </tr>
              <tr>
                <td class="label">Sale Date</td>
                <td class="value">{{ carInfo.soldDate ? new Date(carInfo.soldDate).toLocaleDateString() : '--' }}</td>
              </tr>
              <tr>
                <td class="label">Accessories</td>
                <td class="value">{{ carInfo.optionsAccessories ? carInfo.optionsAccessories : '--' }}</td>
              </tr>
              <tr>
                <td class="label">Auction Information</td>
                <td class="value">--</td>
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
            v-for="(item, key) in carInfo.conditionDescription.split(',')"
            v-if="carInfo.conditionDescription"
            :key="key"
            class="rounded ma-1"
            color="white"
            style="background: #ff5a60!important;"
          >
            <div class="text-white">{{ item }}</div>
          </v-chip>
        </v-row>
        <v-row class="d-flex">
          <v-col cols="12" lg="6" md="6" sm="12">
            <v-row>
                <span class="text-h6 font-weight-bold align-self-center">
                  Tyre Condition
                </span>
            </v-row>
            <v-row>
              <table class="vehicle-tyre-table">
                <tbody>
                <tr>
                  <td class="label">Left Front</td>
                  <td class="value">{{ carInfo.tyreFrontNearCondition ? carInfo.tyreFrontNearCondition : '--' }}</td>
                </tr>
                <tr>
                  <td class="label">Left Rear</td>
                  <td class="value">{{ carInfo.tyreFrontOffCondition ? carInfo.tyreFrontOffCondition : '--' }}</td>
                </tr>
                <tr>
                  <td class="label">Right Front</td>
                  <td class="value">{{ carInfo.tyreRearNearCondition ? carInfo.tyreRearNearCondition : '--' }}</td>
                </tr>
                <tr>
                  <td class="label">Right Rear</td>
                  <td class="value">{{ carInfo.tyreRearOffCondition ? carInfo.tyreRearOffCondition : '--' }}</td>
                </tr>
                <tr>
                  <td class="label">Spare</td>
                  <td class="value">{{ carInfo.tyreSpareCondition ? carInfo.tyreSpareCondition : '--' }}</td>
                </tr>
                </tbody>
              </table>
            </v-row>
          </v-col>
          <v-col cols="12" lg="6" md="6" sm="12">
            <v-row>
                    <span class="text-h6 font-weight-bold align-self-center">
                      Keys & Books
                    </span>
            </v-row>
            <v-row>
              <table class="vehicle-tyre-table">
                <tbody>
                <tr>
                  <td class="label">Log Books</td>
                  <td class="value">{{ carInfo.logBooks ? carInfo.logBooks : '--' }}</td>
                </tr>
                <tr>
                  <td class="label">Owners Manual</td>
                  <td class="value">{{ carInfo.ownerManualStatus ? carInfo.ownerManualStatus : '--' }}</td>
                </tr>
                <tr>
                  <td class="label">Keys</td>
                  <td class="value">{{ carInfo.keysStatus ? carInfo.keysStatus : '--' }}</td>
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
      make: {
        title: 'Make',
        value: 'Audi'
      },
      model: {
        title: 'Model',
        value: 'A1'
      },
      yearGroup: {
        title: 'Year',
        value: '2012'
      },
      description: {
        title: 'Description',
        value: '8X MY12 Ambition Hatchback 3dr Man 6sp 1.4T'
      },
      colour: {
        title: 'Colour',
        value: 'Silver'
      },
      engineDescription: {
        title: 'Engine',
        value: '1.4 Direct Injection Turbo Petrol'
      },
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
      "Left Front": '--',
      "Left Rear": '--',
      "Right Front": '--',
      "Right Rear": '--',
      "Spare": '--'
    },
    keysAndBooks: {
      "Log Books": '--',
      "Owners Manual": '--',
      "Keys": '--',
    }
  }),
  props: {
    carInfo: {
      type: Object,
      required: true
    }
  },
  methods: {}
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
