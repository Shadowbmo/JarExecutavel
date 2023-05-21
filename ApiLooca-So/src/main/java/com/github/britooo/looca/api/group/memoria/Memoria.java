package com.github.britooo.looca.api.group.memoria;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import com.github.britooo.looca.api.util.Conversor;


public class Memoria {

    private final HardwareAbstractionLayer hardware = new SystemInfo().getHardware();

    /**
     * Retorna a quantidade de <b>memória física</b> atualmente <b>disponível</b>, <b>em bytes</b>.
     *
     * @return Quantidade de memória física atualmente disponível, <b>em bytes</b>.
     */
    public Double getDisponivel() {
        return convertBytesToGigabytes(this.hardware.getMemory().getAvailable());
    }

    /**
     * Retorna a quantidade de <b>memória física real</b>, <b>em bytes</b>.
     *
     * @return Quantidade de memória física real, <b>em bytes</b>.
     */
    public Double getTotal() {
        return convertBytesToGigabytes(this.hardware.getMemory().getTotal());
    }

    /**
     * Retorna a quantidade de <b>memória em uso</b>, <b>em bytes</b>.
     *
     * @return Quantidade de memória em uso, <b>em bytes</b>.
     */
public Double getEmUso() {
    double total = getTotal();
    double disponivel = getDisponivel();
    return (total - disponivel);
}


    /**
     * Converte um valor em bytes para gigabytes.
     *
     * @param bytes Valor em bytes a ser convertido.
     * @return Valor convertido para gigabytes.
     */
    private Double convertBytesToGigabytes(long bytes) {
        return bytes / (1024.0 * 1024.0 * 1024.0);
    }

    /**
     * Retorna uma <code>String</code> com todas as informações relacionadas a <b>Memória</b>.
     *
     * @return <code>String</code> com todas as informações relacionadas a <b>Memória</b>.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Memoria").append("\n");

        sb.append("Em uso: ")
                .append(String.format("%.2f", getEmUso()))
                .append(" GB\n");

        sb.append("Disponível: ")
                .append(String.format("%.2f", getDisponivel()))
                .append(" GB\n");

        sb.append("Total: ")
                .append(String.format("%.2f", getTotal()))
                .append(" GB\n");

        return sb.toString();
    }
}

