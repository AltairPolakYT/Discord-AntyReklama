package me.altair.event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;

public class AntiAdvertisement extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        
        if (event.getMessage().getContentRaw().contains("https://discord.gg/") || event.getMessage().getContentRaw().contains("https://discord.io/") || event.getMessage().getContentRaw().contains("https://dsc.gg/") || event.getMessage().getContentRaw().contains("https://invites.gg/")) {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setColor(Color.RED.getRGB());
            builder.setAuthor("NazwaTwojegoBota", event.getMessage().getAuthor().getAvatarUrl(), event.getMessage().getAuthor().getAvatarUrl());
            builder.setTitle("AntyReklama!");
            builder.setDescription("**Na serwerze zabronione jest wysyłanie zaproszeń!**");
            builder.setFooter("link wysłał " + event.getAuthor().getName());
            event.getMessage().delete().queue();
            event.getTextChannel().sendMessageEmbeds(builder.build(), new MessageEmbed[0]).queue();
        }

    }
}
