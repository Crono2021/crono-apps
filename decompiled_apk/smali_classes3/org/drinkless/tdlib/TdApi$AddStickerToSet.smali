.class public Lorg/drinkless/tdlib/TdApi$AddStickerToSet;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddStickerToSet"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x56dc1e3b


# instance fields
.field public name:Ljava/lang/String;

.field public sticker:Lorg/drinkless/tdlib/TdApi$InputSticker;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35486
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35487
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Lorg/drinkless/tdlib/TdApi$InputSticker;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "inputSticker"    # Lorg/drinkless/tdlib/TdApi$InputSticker;

    .line 35475
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35476
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddStickerToSet;->userId:J

    .line 35477
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AddStickerToSet;->name:Ljava/lang/String;

    .line 35478
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AddStickerToSet;->sticker:Lorg/drinkless/tdlib/TdApi$InputSticker;

    .line 35479
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35483
    const v0, 0x56dc1e3b

    return v0
.end method
