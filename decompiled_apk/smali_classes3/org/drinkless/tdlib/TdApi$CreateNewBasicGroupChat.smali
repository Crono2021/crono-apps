.class public Lorg/drinkless/tdlib/TdApi$CreateNewBasicGroupChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateNewBasicGroupChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$CreatedBasicGroupChat;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6bac4fb5


# instance fields
.field public messageAutoDeleteTime:I

.field public title:Ljava/lang/String;

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36476
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36477
    return-void
.end method

.method public constructor <init>([JLjava/lang/String;I)V
    .locals 0
    .param p1, "jArr"    # [J
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "i9"    # I

    .line 36465
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36466
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CreateNewBasicGroupChat;->userIds:[J

    .line 36467
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$CreateNewBasicGroupChat;->title:Ljava/lang/String;

    .line 36468
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$CreateNewBasicGroupChat;->messageAutoDeleteTime:I

    .line 36469
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36473
    const v0, 0x6bac4fb5

    return v0
.end method
