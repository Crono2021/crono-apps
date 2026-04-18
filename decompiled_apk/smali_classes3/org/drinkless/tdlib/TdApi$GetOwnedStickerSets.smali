.class public Lorg/drinkless/tdlib/TdApi$GetOwnedStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetOwnedStickerSets"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StickerSets;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x58fe8120


# instance fields
.field public limit:I

.field public offsetStickerSetId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26484
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26485
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 26474
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26475
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetOwnedStickerSets;->offsetStickerSetId:J

    .line 26476
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetOwnedStickerSets;->limit:I

    .line 26477
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26481
    const v0, 0x58fe8120

    return v0
.end method
