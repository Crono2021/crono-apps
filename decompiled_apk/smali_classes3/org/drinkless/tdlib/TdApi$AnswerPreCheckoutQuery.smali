.class public Lorg/drinkless/tdlib/TdApi$AnswerPreCheckoutQuery;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AnswerPreCheckoutQuery"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x589e9c15


# instance fields
.field public errorMessage:Ljava/lang/String;

.field public preCheckoutQueryId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22864
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22865
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 22854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22855
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AnswerPreCheckoutQuery;->preCheckoutQueryId:J

    .line 22856
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AnswerPreCheckoutQuery;->errorMessage:Ljava/lang/String;

    .line 22857
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22861
    const v0, -0x589e9c15

    return v0
.end method
