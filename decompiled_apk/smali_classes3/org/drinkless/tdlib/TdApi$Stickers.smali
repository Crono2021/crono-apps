.class public Lorg/drinkless/tdlib/TdApi$Stickers;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Stickers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x75b5f5fc


# instance fields
.field public stickers:[Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20310
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20311
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "stickerArr"    # [Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 20301
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20302
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Stickers;->stickers:[Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 20303
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20307
    const v0, 0x75b5f5fc

    return v0
.end method
