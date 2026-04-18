.class public Lorg/drinkless/tdlib/TdApi$SendCallRating;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendCallRating"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x539bcd0e


# instance fields
.field public callId:I

.field public comment:Ljava/lang/String;

.field public problems:[Lorg/drinkless/tdlib/TdApi$CallProblem;

.field public rating:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45126
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45127
    return-void
.end method

.method public constructor <init>(IILjava/lang/String;[Lorg/drinkless/tdlib/TdApi$CallProblem;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "callProblemArr"    # [Lorg/drinkless/tdlib/TdApi$CallProblem;

    .line 45114
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45115
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SendCallRating;->callId:I

    .line 45116
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SendCallRating;->rating:I

    .line 45117
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SendCallRating;->comment:Ljava/lang/String;

    .line 45118
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SendCallRating;->problems:[Lorg/drinkless/tdlib/TdApi$CallProblem;

    .line 45119
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45123
    const v0, -0x539bcd0e

    return v0
.end method
