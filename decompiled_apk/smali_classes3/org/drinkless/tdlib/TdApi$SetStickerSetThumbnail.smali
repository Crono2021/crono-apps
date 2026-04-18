.class public Lorg/drinkless/tdlib/TdApi$SetStickerSetThumbnail;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetStickerSetThumbnail"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x63fe6932


# instance fields
.field public format:Lorg/drinkless/tdlib/TdApi$StickerFormat;

.field public name:Ljava/lang/String;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45270
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45271
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$StickerFormat;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p5, "stickerFormat"    # Lorg/drinkless/tdlib/TdApi$StickerFormat;

    .line 45258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45259
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetStickerSetThumbnail;->userId:J

    .line 45260
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetStickerSetThumbnail;->name:Ljava/lang/String;

    .line 45261
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SetStickerSetThumbnail;->thumbnail:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 45262
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SetStickerSetThumbnail;->format:Lorg/drinkless/tdlib/TdApi$StickerFormat;

    .line 45263
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45267
    const v0, 0x63fe6932

    return v0
.end method
