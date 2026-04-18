.class public Lorg/drinkless/tdlib/TdApi$ViewTrendingStickerSets;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ViewTrendingStickerSets"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x38c4b908


# instance fields
.field public stickerSetIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22646
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22647
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 22637
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22638
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ViewTrendingStickerSets;->stickerSetIds:[J

    .line 22639
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22643
    const v0, -0x38c4b908

    return v0
.end method
