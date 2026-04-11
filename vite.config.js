import { defineConfig } from 'vite';
import { nodePolyfills } from 'vite-plugin-node-polyfills';
import { resolve } from 'path';

export default defineConfig({
    plugins: [
        nodePolyfills({
            globals: {
                Buffer: true,
                global: true,
                process: true,
            },
            protocolImports: true,
        }),
    ],
    resolve: {
        alias: {
            // Ensure ALL modules that import 'buffer' get the same package
            buffer: resolve('./node_modules/buffer'),
        },
    },
    build: {
        outDir: 'dist',
        sourcemap: false,
    },
    server: {
        port: 3001,
    },
    preview: {
        host: '0.0.0.0',
        allowedHosts: ['cineflix-production-19e3.up.railway.app', '.railway.app'],
    },
});
