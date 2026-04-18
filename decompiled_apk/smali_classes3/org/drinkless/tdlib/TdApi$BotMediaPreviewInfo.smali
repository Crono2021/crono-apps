.class public Lorg/drinkless/tdlib/TdApi$BotMediaPreviewInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotMediaPreviewInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x10f971a4


# instance fields
.field public languageCodes:[Ljava/lang/String;

.field public previews:[Lorg/drinkless/tdlib/TdApi$BotMediaPreview;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23264
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23265
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$BotMediaPreview;[Ljava/lang/String;)V
    .locals 0
    .param p1, "botMediaPreviewArr"    # [Lorg/drinkless/tdlib/TdApi$BotMediaPreview;
    .param p2, "strArr"    # [Ljava/lang/String;

    .line 23254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23255
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BotMediaPreviewInfo;->previews:[Lorg/drinkless/tdlib/TdApi$BotMediaPreview;

    .line 23256
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BotMediaPreviewInfo;->languageCodes:[Ljava/lang/String;

    .line 23257
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23261
    const v0, -0x10f971a4

    return v0
.end method
