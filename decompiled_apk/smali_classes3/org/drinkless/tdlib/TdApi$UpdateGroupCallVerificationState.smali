.class public Lorg/drinkless/tdlib/TdApi$UpdateGroupCallVerificationState;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateGroupCallVerificationState"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x28b53844


# instance fields
.field public emojis:[Ljava/lang/String;

.field public generation:I

.field public groupCallId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41648
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41649
    return-void
.end method

.method public constructor <init>(II[Ljava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "strArr"    # [Ljava/lang/String;

    .line 41637
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41638
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCallVerificationState;->groupCallId:I

    .line 41639
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCallVerificationState;->generation:I

    .line 41640
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateGroupCallVerificationState;->emojis:[Ljava/lang/String;

    .line 41641
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41645
    const v0, 0x28b53844

    return v0
.end method
