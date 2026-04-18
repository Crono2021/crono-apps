.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentRecurringPayment;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentRecurringPayment"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6083361a


# instance fields
.field public amount:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18222
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18223
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 18213
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18214
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentRecurringPayment;->amount:Ljava/lang/String;

    .line 18215
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18219
    const v0, 0x6083361a

    return v0
.end method
