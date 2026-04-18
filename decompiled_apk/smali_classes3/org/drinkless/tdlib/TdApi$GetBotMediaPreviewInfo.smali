.class public Lorg/drinkless/tdlib/TdApi$GetBotMediaPreviewInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBotMediaPreviewInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BotMediaPreviewInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x50f60136


# instance fields
.field public botUserId:J

.field public languageCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25724
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25725
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 25714
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25715
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetBotMediaPreviewInfo;->botUserId:J

    .line 25716
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetBotMediaPreviewInfo;->languageCode:Ljava/lang/String;

    .line 25717
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25721
    const v0, 0x50f60136

    return v0
.end method
