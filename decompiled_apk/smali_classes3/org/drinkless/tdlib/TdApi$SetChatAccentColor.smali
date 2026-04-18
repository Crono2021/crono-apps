.class public Lorg/drinkless/tdlib/TdApi$SetChatAccentColor;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatAccentColor"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x349f57ca


# instance fields
.field public accentColorId:I

.field public backgroundCustomEmojiId:J

.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40174
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40175
    return-void
.end method

.method public constructor <init>(JIJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "j9"    # J

    .line 40163
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40164
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatAccentColor;->chatId:J

    .line 40165
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatAccentColor;->accentColorId:I

    .line 40166
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$SetChatAccentColor;->backgroundCustomEmojiId:J

    .line 40167
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40171
    const v0, 0x349f57ca

    return v0
.end method
