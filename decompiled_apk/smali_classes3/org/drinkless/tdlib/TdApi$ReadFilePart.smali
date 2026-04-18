.class public Lorg/drinkless/tdlib/TdApi$ReadFilePart;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReadFilePart"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Data;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xa67d4b6


# instance fields
.field public count:J

.field public fileId:I

.field public offset:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39360
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39361
    return-void
.end method

.method public constructor <init>(IJJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "j9"    # J

    .line 39349
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39350
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ReadFilePart;->fileId:I

    .line 39351
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ReadFilePart;->offset:J

    .line 39352
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$ReadFilePart;->count:J

    .line 39353
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39357
    const v0, -0xa67d4b6

    return v0
.end method
