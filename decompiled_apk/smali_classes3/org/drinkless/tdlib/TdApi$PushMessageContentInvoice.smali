.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentInvoice;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentInvoice"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x67377444


# instance fields
.field public isPinned:Z

.field public price:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29568
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29569
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 29558
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29559
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentInvoice;->price:Ljava/lang/String;

    .line 29560
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentInvoice;->isPinned:Z

    .line 29561
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29565
    const v0, -0x67377444

    return v0
.end method
