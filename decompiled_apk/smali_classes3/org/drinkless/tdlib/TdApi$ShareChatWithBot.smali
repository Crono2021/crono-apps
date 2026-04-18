.class public Lorg/drinkless/tdlib/TdApi$ShareChatWithBot;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ShareChatWithBot"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x59acf51e


# instance fields
.field public buttonId:I

.field public chatId:J

.field public messageId:J

.field public onlyCheck:Z

.field public sharedChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48736
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48737
    return-void
.end method

.method public constructor <init>(JJIJZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "j10"    # J
    .param p8, "z8"    # Z

    .line 48723
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48724
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ShareChatWithBot;->chatId:J

    .line 48725
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ShareChatWithBot;->messageId:J

    .line 48726
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ShareChatWithBot;->buttonId:I

    .line 48727
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$ShareChatWithBot;->sharedChatId:J

    .line 48728
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$ShareChatWithBot;->onlyCheck:Z

    .line 48729
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48733
    const v0, -0x59acf51e

    return v0
.end method
