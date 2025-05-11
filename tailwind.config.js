/** @type {import('tailwindcss').Config} */
export default {
  content: ['./index.html', './src/**/*.{js,ts,jsx,tsx}'],
  darkMode: 'class',
  theme: {
    extend: {
      colors: {
        primary: {
          DEFAULT: 'rgb(var(--color-primary))',
          dark: 'rgb(var(--color-primary-dark))',
          light: 'rgb(var(--color-primary) / 0.8)',
        },
        secondary: {
          DEFAULT: 'rgb(var(--color-secondary))',
          dark: 'rgb(var(--color-secondary-dark))',
          light: 'rgb(var(--color-secondary) / 0.8)',
        },
      },
      animation: {
        'pulse-slow': 'pulse 3s cubic-bezier(0.4, 0, 0.6, 1) infinite',
      },
      transitionProperty: {
        'height': 'height',
        'spacing': 'margin, padding',
      },
      boxShadow: {
        'card': '0 2px 5px 0 rgb(0 0 0 / 0.05)',
      },
    },
  },
  plugins: [],
};