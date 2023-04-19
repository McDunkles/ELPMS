<script setup lang="ts">
import MenuOptionItem from './MenuOptionItem.vue'
</script>

<template>
  <h2>
    Main Menu
  </h2>

  <MenuOptionItem :option="'make'">
    <template #heading>Make A Drink</template>
  </MenuOptionItem>

  <MenuOptionItem :option="'liquidLevels'">
    <template #heading>Check Liquid Levels</template>
  </MenuOptionItem>

  <MenuOptionItem :option="'settings'">
    <template #heading>Settings</template>
  </MenuOptionItem>
</template>

<style scoped>

h2 {

  margin-top: 2rem;
  flex: 1;
  text-align: center;

  font-size: 2.5rem;
  font-weight: 600;
  margin-bottom: 0.4rem;
  color: var(--color-heading);
}

</style>