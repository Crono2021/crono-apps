.class public Lorg/drinkless/tdlib/TdApi$UpdateRecentStickers;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateRecentStickers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x71a168d4


# instance fields
.field public isAttached:Z

.field public stickerIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34828
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34829
    return-void
.end method

.method public constructor <init>(Z[I)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "iArr"    # [I

    .line 34818
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34819
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateRecentStickers;->isAttached:Z

    .line 34820
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateRecentStickers;->stickerIds:[I

    .line 34821
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34825
    const v0, 0x71a168d4

    return v0
.end method
