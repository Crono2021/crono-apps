.class public Lorg/drinkless/tdlib/TdApi$GetBotInfoDescription;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBotInfoDescription"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2d7807cb


# instance fields
.field public botUserId:J

.field public languageCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25684
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25685
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 25674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25675
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetBotInfoDescription;->botUserId:J

    .line 25676
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetBotInfoDescription;->languageCode:Ljava/lang/String;

    .line 25677
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25681
    const v0, -0x2d7807cb

    return v0
.end method
