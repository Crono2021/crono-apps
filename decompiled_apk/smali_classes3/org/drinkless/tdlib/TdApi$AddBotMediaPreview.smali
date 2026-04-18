.class public Lorg/drinkless/tdlib/TdApi$AddBotMediaPreview;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddBotMediaPreview"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BotMediaPreview;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x504b852b


# instance fields
.field public botUserId:J

.field public content:Lorg/drinkless/tdlib/TdApi$InputStoryContent;

.field public languageCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35310
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35311
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Lorg/drinkless/tdlib/TdApi$InputStoryContent;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "inputStoryContent"    # Lorg/drinkless/tdlib/TdApi$InputStoryContent;

    .line 35299
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35300
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddBotMediaPreview;->botUserId:J

    .line 35301
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AddBotMediaPreview;->languageCode:Ljava/lang/String;

    .line 35302
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AddBotMediaPreview;->content:Lorg/drinkless/tdlib/TdApi$InputStoryContent;

    .line 35303
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35307
    const v0, 0x504b852b

    return v0
.end method
