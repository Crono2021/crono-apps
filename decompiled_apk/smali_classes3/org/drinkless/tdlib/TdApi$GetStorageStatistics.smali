.class public Lorg/drinkless/tdlib/TdApi$GetStorageStatistics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStorageStatistics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StorageStatistics;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x32dab4c9


# instance fields
.field public chatLimit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13686
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13687
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 13677
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13678
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetStorageStatistics;->chatLimit:I

    .line 13679
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13683
    const v0, -0x32dab4c9    # -1.7332312E8f

    return v0
.end method
