.class public Lorg/drinkless/tdlib/TdApi$GetBotInfoShortDescription;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBotInfoShortDescription"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4a1c2614


# instance fields
.field public botUserId:J

.field public languageCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25704
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25705
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 25694
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25695
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetBotInfoShortDescription;->botUserId:J

    .line 25696
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetBotInfoShortDescription;->languageCode:Ljava/lang/String;

    .line 25697
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25701
    const v0, 0x4a1c2614    # 2558341.0f

    return v0
.end method
