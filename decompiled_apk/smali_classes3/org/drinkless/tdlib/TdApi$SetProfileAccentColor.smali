.class public Lorg/drinkless/tdlib/TdApi$SetProfileAccentColor;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetProfileAccentColor"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x76643e98


# instance fields
.field public profileAccentColorId:I

.field public profileBackgroundCustomEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31768
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31769
    return-void
.end method

.method public constructor <init>(IJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J

    .line 31758
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31759
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SetProfileAccentColor;->profileAccentColorId:I

    .line 31760
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$SetProfileAccentColor;->profileBackgroundCustomEmojiId:J

    .line 31761
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31765
    const v0, -0x76643e98

    return v0
.end method
