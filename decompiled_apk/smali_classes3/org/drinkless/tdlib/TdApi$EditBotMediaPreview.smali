.class public Lorg/drinkless/tdlib/TdApi$EditBotMediaPreview;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditBotMediaPreview"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BotMediaPreview;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x796aa29e


# instance fields
.field public botUserId:J

.field public content:Lorg/drinkless/tdlib/TdApi$InputStoryContent;

.field public fileId:I

.field public languageCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43062
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43063
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;ILorg/drinkless/tdlib/TdApi$InputStoryContent;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "inputStoryContent"    # Lorg/drinkless/tdlib/TdApi$InputStoryContent;

    .line 43050
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43051
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditBotMediaPreview;->botUserId:J

    .line 43052
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EditBotMediaPreview;->languageCode:Ljava/lang/String;

    .line 43053
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$EditBotMediaPreview;->fileId:I

    .line 43054
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$EditBotMediaPreview;->content:Lorg/drinkless/tdlib/TdApi$InputStoryContent;

    .line 43055
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43059
    const v0, -0x796aa29e

    return v0
.end method
