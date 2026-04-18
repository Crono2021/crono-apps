.class public Lorg/drinkless/tdlib/TdApi$GetCustomEmojiStickers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetCustomEmojiStickers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Stickers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7ecdf973


# instance fields
.field public customEmojiIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12714
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12715
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 12705
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12706
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetCustomEmojiStickers;->customEmojiIds:[J

    .line 12707
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12711
    const v0, -0x7ecdf973

    return v0
.end method
