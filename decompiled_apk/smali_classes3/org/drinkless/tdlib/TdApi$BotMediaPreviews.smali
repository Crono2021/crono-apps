.class public Lorg/drinkless/tdlib/TdApi$BotMediaPreviews;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotMediaPreviews"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6a8e738a


# instance fields
.field public previews:[Lorg/drinkless/tdlib/TdApi$BotMediaPreview;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9150
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9151
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$BotMediaPreview;)V
    .locals 0
    .param p1, "botMediaPreviewArr"    # [Lorg/drinkless/tdlib/TdApi$BotMediaPreview;

    .line 9141
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9142
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BotMediaPreviews;->previews:[Lorg/drinkless/tdlib/TdApi$BotMediaPreview;

    .line 9143
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9147
    const v0, -0x6a8e738a

    return v0
.end method
