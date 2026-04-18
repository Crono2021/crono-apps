.class public Lorg/drinkless/tdlib/TdApi$DropGiftOriginalDetails;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DropGiftOriginalDetails"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x531d8e13


# instance fields
.field public receivedGiftId:Ljava/lang/String;

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25304
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25305
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J

    .line 25294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25295
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DropGiftOriginalDetails;->receivedGiftId:Ljava/lang/String;

    .line 25296
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$DropGiftOriginalDetails;->starCount:J

    .line 25297
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25301
    const v0, -0x531d8e13

    return v0
.end method
