.class public Lorg/drinkless/tdlib/TdApi$ChatEventActiveUsernamesChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventActiveUsernamesChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x59ee521a


# instance fields
.field public newUsernames:[Ljava/lang/String;

.field public oldUsernames:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23664
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23665
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;
    .param p2, "strArr2"    # [Ljava/lang/String;

    .line 23654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23655
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventActiveUsernamesChanged;->oldUsernames:[Ljava/lang/String;

    .line 23656
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventActiveUsernamesChanged;->newUsernames:[Ljava/lang/String;

    .line 23657
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23661
    const v0, -0x59ee521a

    return v0
.end method
