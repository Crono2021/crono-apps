.class public Lorg/drinkless/tdlib/TdApi$GetPreparedInlineMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPreparedInlineMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PreparedInlineMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4f538b5


# instance fields
.field public botUserId:J

.field public preparedMessageId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26605
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 26594
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26595
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetPreparedInlineMessage;->botUserId:J

    .line 26596
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetPreparedInlineMessage;->preparedMessageId:Ljava/lang/String;

    .line 26597
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26601
    const v0, -0x4f538b5

    return v0
.end method
