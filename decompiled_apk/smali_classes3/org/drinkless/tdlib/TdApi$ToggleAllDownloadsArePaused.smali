.class public Lorg/drinkless/tdlib/TdApi$ToggleAllDownloadsArePaused;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleAllDownloadsArePaused"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4a989002


# instance fields
.field public arePaused:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21350
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21351
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 21341
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21342
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleAllDownloadsArePaused;->arePaused:Z

    .line 21343
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21347
    const v0, 0x4a989002    # 4999169.0f

    return v0
.end method
