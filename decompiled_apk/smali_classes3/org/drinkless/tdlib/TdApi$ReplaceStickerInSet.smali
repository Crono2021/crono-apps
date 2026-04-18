.class public Lorg/drinkless/tdlib/TdApi$ReplaceStickerInSet;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReplaceStickerInSet"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1837d1e7


# instance fields
.field public name:Ljava/lang/String;

.field public newSticker:Lorg/drinkless/tdlib/TdApi$InputSticker;

.field public oldSticker:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44862
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44863
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputSticker;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p5, "inputSticker"    # Lorg/drinkless/tdlib/TdApi$InputSticker;

    .line 44850
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44851
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReplaceStickerInSet;->userId:J

    .line 44852
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ReplaceStickerInSet;->name:Ljava/lang/String;

    .line 44853
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ReplaceStickerInSet;->oldSticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 44854
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ReplaceStickerInSet;->newSticker:Lorg/drinkless/tdlib/TdApi$InputSticker;

    .line 44855
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44859
    const v0, -0x1837d1e7

    return v0
.end method
